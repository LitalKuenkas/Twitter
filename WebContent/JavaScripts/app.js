
var servicesModule = angular.module("services", []);
var directivesModule = angular.module("directives", []);
var controllersModule = angular.module("controllers", []);

var mainModule = angular.module("twitterMain", ["services", "controllers","directives"]);