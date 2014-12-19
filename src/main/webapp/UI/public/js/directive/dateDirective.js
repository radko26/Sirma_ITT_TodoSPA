mainApp.directive('dateDirective', function ($compile) {
	return {
		scope : {
			task : '='
		},
		link : function(scope,element,attr){
			if(scope.task.expire == 0){
				
			}else{
				var date = new Date(scope.task.expire);
				element.append(date.toDateString());
			}
		}

	};
});
