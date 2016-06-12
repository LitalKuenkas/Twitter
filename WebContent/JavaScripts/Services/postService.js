servicesModule.service("postService", function($http){

	var mypostService = {
		getNewsFeed : function(acceptedUserID, succFunc) {
			$http.post("/Twitter/rest/posts/newsfeed", {"userID" : acceptedUserID}).success(succFunc);
		}
	}
	
	return mypostService;

});