mainApp.directive('successDirective', function() {
	return {
		scope : {
			task : '='
		},
		link : function(scope, element, attr) {
			if (scope.task.finished) {
				element.addClass("success");
			}
		}
	};
});