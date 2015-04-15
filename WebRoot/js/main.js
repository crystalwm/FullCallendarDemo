$(
		function(){
			$("#calendar").fullCalendar({
				lang:"zh-cn",   //设置language
				timeFormat: 'H(:mm)',   // 设置时间格式
                header:{
                	left: 'prev,next today', 
                    center: 'title', 
                    right: 'month,agendaWeek,agendaDay'
                },
                theme:true,   //设置主题
                minTime:"08:00:00"  ,  //设置开始时间
                maxTime:"22:00:00"  ,   //设置结束时间
                defaultView:"agendaWeek", //默认显示的日期是周
                allDaySlot:false   ,       //让最上面的全天不要显示出
                selectable:true,         //允许选择
                selectHelper: true,     //提示选择的时间
                selectOverlap:false   ,   //不允许重复选择
                editable:true,  //允许编辑
    			select: function(start, end) {
    				var title = prompt('Event Title:');
    				var eventData;
    				if (title) {
    					eventData = {
    						title: title,
    						start: start,
    						end: end
    					};
    					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
    				}
    				$('#calendar').fullCalendar('unselect');
    			},
    		    events: 'MeetingRoom/GetFullCalendarData?uid=08321&uroom=room1'，
    			select: function(start, end, allDay) {
    				if(start.getTime()<=new Date().getTime()){
    					alert("开始时间已过期!");
    				}else{
    					var title = prompt('会议主题:');
    					if (title) {
    						$.getJSON("/MeetingRoom/addRoomEvent",{start: start.getTime(), end: end.getTime(), roomId: roomId, title: title}, function(data){
    							if(data.isSuccess){
    								$('#calendar').fullCalendar('refetchEvents');
    							}else{
    								alert(data.msg);
    							}
    						});
    					}
    				}
    			}
    		    
                
                
			});
			
			
			$('#datetimepicker').datetimepicker({
				  format:'d.m.Y',
				  inline:true,
				  lang:'zh',
				  timepicker:false ,  //让时间默认不显示出来
				  //当datepicker控件去影响fullcalendar控件
				  onChangeDateTime:function(current_time){  
						$('#calendar').fullCalendar('gotoDate',current_time);
						
					}
				});
           

			
		
		});