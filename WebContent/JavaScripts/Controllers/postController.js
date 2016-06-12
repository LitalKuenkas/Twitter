controllersModule.controller("postController", function($scope,postService){
//	$scope.newfeed = [{title: "bla", userName: "lital", creationDate: Date(), content: "this is my first twit"},
//	                  {title: "bla2", userName: "lital", creationDate: Date(), content: "this is my second twit"}];	
	
	$scope.currentUserId = 0;
	
    function successPosts(res) {
    	$scope.newfeed = res;
    }
    
	postService.getNewsFeed(1, successPosts);
	
	$scope.getNewsFeed = function(){
		postService.getNewFeed($scope.currentUserId, successPosts);
	}
	
});