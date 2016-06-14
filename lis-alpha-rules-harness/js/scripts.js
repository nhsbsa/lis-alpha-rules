var lisRuleExploreApp = angular.module('lisRuleExploreApp', []);

lisRuleExploreApp.controller('LISRuleExploreController', function LisFormFields($scope, $document) {

	  var json = {	
	    "address":{ 
		    "value":{ 
		        "houseNameNumber":{ "value":"10", "validation":"required", "rule":"A1.1", "trigger":"false"},
			    "postcode":{ "value":"NE1 6SN", "validation":"required", "trigger":"true", "rule":"A1.1"},
			 }
	     },
		 "assessment":{ "value":"1234", "validation":"required", "rule":"A1.1", "trigger":"false"}
	  };
	  
	  $scope.editFormEnabled = false;
	  
	  $scope.lisTableArray = [];
	  $scope.tableCount = 0;
	  
	  $scope.refreshTable = function(jsonData) {
	      var json = JSON.parse(jsonData);
		  
		  $scope.tableCount = 0;
		  
		  // make sure the root table is created first as the first json element may be a complex one
		  var rootTable = [];
		  rootTable.tableName = "root";
		  $scope.lisTableArray.push(rootTable);
		  
		  // parse json object into array of [name, value, validation, rule, trigger]
		  $scope.handleJson(json, "root", $scope.tableCount);
	  };
	  
	  $scope.handleJson = function(json, tableName, currentTable) {
		  for(var lisFormFieldProperty in json) {
			  $scope.handleLisField(json, lisFormFieldProperty, tableName, currentTable);
		  }
	  };
	  
	  $scope.handleLisField = function(json, lisFormFieldProperty, tableName, currentTable) {
		  if(json.hasOwnProperty(lisFormFieldProperty)) {
		      if(typeof json[lisFormFieldProperty].value === 'object') {
				  var jsonNewObj = json[lisFormFieldProperty].value;
				  $scope.tableCount = $scope.tableCount+1;
				  $scope.handleJson(jsonNewObj, lisFormFieldProperty, $scope.tableCount);
			  }
              else {
				  var tableFieldArray = $scope.lisTableArray[currentTable];
				  if(tableFieldArray == null) {
					  tableFieldArray = [];
					  tableFieldArray.tableName = tableName;
					  $scope.lisTableArray.push(tableFieldArray);
				  }
				  
				  var fieldJson = $scope.jsonSimpleFieldToTableArray(
				      json, 
					  lisFormFieldProperty);
				  tableFieldArray.push(fieldJson);
              }					  
	      }
	  };
	  
	  $scope.jsonSimpleFieldToTableArray = function(json, lisFormFieldProperty) {
	      return {
			   name:lisFormFieldProperty, 
			   value:json[lisFormFieldProperty].value, 
			   validation:json[lisFormFieldProperty].validation, 
			   rule:json[lisFormFieldProperty].rule, 
			   trigger:json[lisFormFieldProperty].trigger
			  };
	  };
	  
	  $scope.saveLisForm = function() {
		  for(var tableIdx in $scope.lisTableArray) {
			  var tableObj = $scope.lisTableArray[tableIdx];
		  }
		  
		  $scope.editFormEnabled = !$scope.editFormEnabled
	  };
	  
	  $scope.refreshTable(JSON.stringify(json));
});