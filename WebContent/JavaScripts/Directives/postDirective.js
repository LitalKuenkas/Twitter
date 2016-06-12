directivesModule.directive("post",function(){
	return {
		restrict: "E",
		templateUrl : "Views/post.html",
		controller : "postController",
		controllerAs : "post"
	};
});