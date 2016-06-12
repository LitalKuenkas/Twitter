servicesModule.service("postService", function($http){

	var mypostService = {
		getNewsFeed : function(acceptedUserID) {
			$http.post("/Twitter/rest/posts/newsfeed", {"userID" : acceptedUserID}).success(function(data){
				return data;
			});
		}
	}
	
	return mypostService;

});