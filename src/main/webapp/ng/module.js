angular.module("myApp", [ "angularBeans", "ngRoute", "pikaday","ngDialog" ])
		.controller("MyCtrl", MyCtrl)
		.controller("AuthentificationCtrl",	AuthentificationCtrl)
		.controller("PageIndexCtrl",	PageIndexCtrl)
		.controller("IndexCtrl", IndexCtrl);
