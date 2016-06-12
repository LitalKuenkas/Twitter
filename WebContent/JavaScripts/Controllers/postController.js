controllersModule.controller("postController", function($scope,postService){
//	$scope.newfeed = [{title: "bla", userName: "lital", creationDate: Date(), content: "this is my first twit"},
//	                  {title: "bla2", userName: "lital", creationDate: Date(), content: "this is my second twit"}];	
	
	$scope.currentUserId = 0;
	
	$scope.newfeed = postService.getNewsFeed(1);
	
	$scope.getNewsFeed = function(postService){
		$scope.newfeed = postService.getNewFeed($scope.currentUserId);
	}
	
});