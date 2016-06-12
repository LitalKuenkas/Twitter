servicesModule.service("postService", function($http){

function getNewFeed(acceptedUserID){
	$http.post("\newsfeed", {"userID" : acceptedUserID}).success(function(data){
		return data;
	})
}
});