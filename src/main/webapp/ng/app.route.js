(function() {
	'use strict';

	angular.module('myApp')

	.config([ '$routeProvider', routeProvider ]).run([ '$route', routeRunner ])

	function routeProvider($routeProvider, $rootScope) {

		$routeProvider

		.when('/', {
			redirectTo : '/hotel'
		})

		.when('/:tpl', {
			templateUrl : function(attr) {
				return ('pages/'+attr.tpl + '.html');
			}
		})

		.when('/404', {
			templateUrl : 'error.html'

		}).otherwise({
			redirectTo : '/404'
		});
	}

	function routeRunner($route) {

	}

})();
