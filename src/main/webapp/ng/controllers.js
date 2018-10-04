function MyCtrl(authentificationBean) {

	var vm = this;

	vm.authentificationBean = authentificationBean;

};
function PageIndexCtrl($rootScope) {

	var vm = this;
	console.log("aa");
	$rootScope.typePage = "login";
};

function IndexCtrl(mvmentPrixHotelBean, $location ,  ngDialog) {

	var vm = this;
	vm.mvmentPrixHotelBean = mvmentPrixHotelBean;

	vm.reserverVol = function(vol) {
		sessionStorage.setItem('vol', JSON.stringify(vol));
		sessionStorage.setItem('type', "V");
		window.location = "contact-new.html";
	}
	vm.reserverHotel = function(hotel) {
		console.log(hotel);
		sessionStorage.setItem('hotel', JSON.stringify(hotel));
		sessionStorage.setItem('type', "H");
		window.location = "contact-new.html";
	}

	vm.searchVol = function() {

		sessionStorage.setItem('adt', vm.mvmentPrixHotelBean.adt);

		if (vm.mvmentPrixHotelBean.mvmentPrixVol.airDepM != null
				&& vm.mvmentPrixHotelBean.mvmentPrixVol.airDepM != ""
				&& vm.mvmentPrixHotelBean.mvmentPrixVol.airDepM != undefined) {
			vm.airDepError = false;
		} else {
			vm.airDepError = true;
		}

		if (vm.mvmentPrixHotelBean.mvmentPrixVol.airArrM != null
				&& vm.mvmentPrixHotelBean.mvmentPrixVol.airArrM != ""
				&& vm.mvmentPrixHotelBean.mvmentPrixVol.airArrM != undefined) {
			vm.airArrError = false;
		} else {
			vm.airArrError = true;
		}
		if (vm.mvmentPrixHotelBean.mvmentPrixVol.dateResM != null
				&& vm.mvmentPrixHotelBean.mvmentPrixVol.dateResM != ""
				&& vm.mvmentPrixHotelBean.mvmentPrixVol.dateResM != undefined) {
			vm.dateResError = false;
		} else {
			vm.dateResError = true;
		}
		if (vm.dateResError == false && vm.airArrError == false
				&& vm.airDepError == false) {

			if (vm.mvmentPrixHotelBean.mvmentPrixVol.dateRetM != null
					& vm.mvmentPrixHotelBean.mvmentPrixVol.dateRetM != undefined
					&& vm.mvmentPrixHotelBean.mvmentPrixVol.dateRetM != "") {
				vm.mvmentPrixHotelBean
						.searchVolRet(vm.mvmentPrixHotelBean.mvmentPrixVol)
						.then(
								function(value) {
									if (vm.mvmentPrixHotelBean.PrixVolsRet.length != 0) {
										$location.path('/flight-result');
									} else {
								        ngDialog.open({ template: 'popupTmpl.html', className: 'ngdialog-theme-default' });
									}
								});
			} else {
				vm.mvmentPrixHotelBean
						.searchVol(vm.mvmentPrixHotelBean.mvmentPrixVol)
						.then(
								function(value) {
									if (vm.mvmentPrixHotelBean.PrixVolsRet.length != 0) {
										$location.path('/flight-result');
									} else {
										ngDialog.open({ template: 'popupTmpl.html', className: 'ngdialog-theme-default' });
										}
								});
			}
		}

	}
	vm.searchHotel = function() {

		sessionStorage.setItem('adt', vm.mvmentPrixHotelBean.adt);
		sessionStorage.setItem('checkIn',
				vm.mvmentPrixHotelBean.mvmentPrixHotel.DateCheckInM);
		sessionStorage.setItem('checkOut',
				vm.mvmentPrixHotelBean.mvmentPrixHotel.DateCheckOutM);
		sessionStorage.setItem('nbrchm',
				vm.mvmentPrixHotelBean.mvmentPrixHotel.nbrchm);

		if (vm.mvmentPrixHotelBean.mvmentPrixHotel.VilleHotelM != null
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.VilleHotelM != ""
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.VilleHotelM != undefined) {
			vm.PaysError = false;
		} else {
			vm.PaysError = true;
		}
		console.log("Type "+vm.mvmentPrixHotelBean.mvmentPrixHotel.LTypeChambreM);
		if (vm.mvmentPrixHotelBean.mvmentPrixHotel.LTypeChambreM != null
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.LTypeChambreM != ""
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.LTypeChambreM != undefined) {
			vm.TypeChambreError = false;
		} else {
			vm.TypeChambreError = true;
		}
		if (vm.mvmentPrixHotelBean.mvmentPrixHotel.DateCheckInM != null
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.DateCheckInM != ""
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.DateCheckInM != undefined) {
			vm.DateCheckInError = false;
		} else {
			vm.DateCheckInError = true;
		}
		if (vm.mvmentPrixHotelBean.mvmentPrixHotel.DateCheckOutM != null
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.DateCheckOutM != ""
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.DateCheckOutM != undefined) {
			vm.DateCheckOutError = false;
		} else {
			vm.DateCheckOutError = true;
		}
		if (vm.mvmentPrixHotelBean.mvmentPrixHotel.nbrchm != null
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.nbrchm != ""
				&& vm.mvmentPrixHotelBean.mvmentPrixHotel.nbrchm != undefined) {
			vm.nbrchmError = false;
		} else {
			vm.nbrchmError = true;
		}

		if (vm.nbrchmError == false && vm.DateCheckOutError == false
				&& vm.DateCheckInError == false && vm.TypeChambreError == false
				&& vm.PaysError == false) {
			vm.mvmentPrixHotelBean.searchHotel(
					vm.mvmentPrixHotelBean.mvmentPrixHotel).then(
					function(value) {
						if (vm.mvmentPrixHotelBean.PrixHotels.length != 0) {
							$location.path('/hotel-result');
						} else {
							alert("Opps! I am an alert box!!");
						}

					});
		}

	}
};

function ContactCtrl(reservationBean, $location, $scope) {

	var vm = this;
	vm.reservationBean = reservationBean;

	$scope.adt = sessionStorage.getItem('adt');

	$scope.type = sessionStorage.getItem('type');
	console.log("TYPE " + $scope.type);
	console.log("ADT " + $scope.adt);
	// $scope.vol.passengers = [];
	vm.reserver = function() {
		if ($scope.type == "V") {
			console.log("VOLLLLLLL");
			$scope.vol = JSON.parse(sessionStorage.getItem('vol'));
			$scope.vol.passengers = [];
			console.log($scope.adt);
			if ($scope.adt > 0) {
				$scope.vol.passengers.push(angular
						.copy(vm.reservationBean.Passenger1))
				if ($scope.adt > 1) {
					$scope.vol.passengers.push(angular
							.copy(vm.reservationBean.Passenger2))
					if ($scope.adt > 2) {
						$scope.vol.passengers.push(angular
								.copy(vm.reservationBean.Passenger3))
						if ($scope.adt > 3) {
							$scope.vol.passengers.push(angular
									.copy(vm.reservationBean.Passenger4))
						}
					}
				}
			}
			$scope.vol.prixVenteR = $scope.vol.prixVenteR * $scope.adt;
			vm.reservationBean.reserverVol($scope.vol);
			window.location = "reussir.html";
		} else if ($scope.type == "H") {
			console.log("Hotellllllllll" + sessionStorage.getItem('hotel'));
			$scope.checkIn = sessionStorage.getItem('checkIn');
			$scope.checkOut = sessionStorage.getItem('checkOut');
			console.log("Date" + $scope.checkIn + "out" + $scope.checkOut)
			$scope.hotel = JSON.parse(sessionStorage.getItem('hotel'));
			$scope.nbrchm = sessionStorage.getItem('nbrchm');
			console.log("nbrchm" + $scope.nbrchm);

			$scope.hotel.DateCheckInR = $scope.checkIn;
			$scope.hotel.DateCheckOutR = $scope.checkOut;

			$scope.hotel.passengers = [];
			console.log($scope.adt);
			if ($scope.adt > 0) {
				$scope.hotel.passengers.push(angular
						.copy(vm.reservationBean.Passenger1))
				if ($scope.adt > 1) {
					$scope.hotel.passengers.push(angular
							.copy(vm.reservationBean.Passenger2))
					if ($scope.adt > 2) {
						$scope.hotel.passengers.push(angular
								.copy(vm.reservationBean.Passenger3))
						if ($scope.adt > 3) {
							$scope.hotel.passengers.push(angular
									.copy(vm.reservationBean.Passenger4))
						}
					}
				}
			}
			$scope.hotel.prixVenteR = $scope.hotel.prixVenteR * $scope.nbrchm;
			vm.reservationBean.reserverHotel($scope.hotel);
			window.location = "reussir.html";
		}
	}

}

function AuthentificationCtrl(authentificationBean, $location, $rootScope) {
	$rootScope.typePage = "login";
	var vm = this;

	vm.authentificationBean = authentificationBean;

	vm.authentification = function(login, pwd) {
		vm.authentificationBean.sauthentifier(login, pwd).then(function(value) {
			if (vm.authentificationBean.utilisateur != "null") {
				console.log("aaaaa");
				$rootScope.typePage = "index";
				// window.location.assign("http://www.w3schools.com")
				window.location = "index.html";
			} else {
				console.log("aaaaaaaaaaaaaaaaaaa");
				vm.authentifier = true;
			}
		});
	}

}
