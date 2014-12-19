mainApp.constant("baseUrl", "http://localhost:8080/SirmaTaskManager/rest/tasks")
.controller("createController", function($scope, $http, baseUrl) {
			$scope.table = [];
			$http.get(baseUrl).success(function(table) {
				$scope.table = table;
			}).error(function(data, status, header, config) {
				alert("failed");

			});

			$scope.taskCopy = {};
			$scope.create = function(task) {
				var expires;
				expires=new Date(task.expire).getTime();
				
				 var taskCopy = {
					content : task.content,
					expire : expires,
					finished : false
				};

				$http.post(baseUrl + "/create", taskCopy).success(function() {
					
					$http.get(baseUrl).success(function(table) {
						$scope.table = table;
					}).error(function(data, status, header, config) {
						alert("failed");

					});
				}).error(function(data, status, header, config) {
					console.log("failed");
				});
				
				
				task.expire="";
				task.content="";
				$('#addTaskFormModal').modal('toggle');
				
			};

			$scope.deleteTask = function(task) {
				$http.delete(baseUrl + "/delete/" + task.id).success(function() {
					
					$http.get(baseUrl).success(function(table) {
						$scope.table = table;
					}).error(function(data, status, header, config) {
						alert("failed");
					});
					
				}).error(function(data, status, header, config) {
					alert("failed");

				});
			};
			
			$scope.markAsFinished = function(task) {			
				$http.post(baseUrl + "/mark", task).success(function() {
					$http.get(baseUrl).success(function(table) {
						$scope.table = table;
					}).error(function(data, status, header, config) {
						alert("failed");

					});
				}).error(function(data, status, header, config) {
					console.log("failed");
				});
			};
			
			$http.get(baseUrl).success(function(table) {
				$scope.table = table;
			}).error(function(data, status, header, config) {
				alert("failed");
			});
			
			$scope.isFinished = function(task){
				return !task.finished;
			};
			
		});