(function($, ko) {

	// Class to represent a Cfp entry.
	function Cfp(sessionType, submitterEmail, sessionTitle, sessionSummary, speakers, speakersBios) {
		var self = this;
		self.sessionType = sessionType;
		self.submitterEmail = submitterEmail;
		self.sessionTitle = sessionTitle;
		self.sessionSummary = sessionSummary;
		self.speakers = speakers;
		self.speakersBios = speakersBios;
	}

	// ViewModel for KO
	function AppViewModel() {
		var self = this;
		self.newCfp = ko.observable({});
		self.cfps = ko.observableArray([]);
	}
	// Apply bindings
	var model = new AppViewModel();
	ko.applyBindings(model);

	// When document is ready ...
	$(document).ready(function() {

		// init Twitter Bootstrap popover.
		$('#sessionTypeDetails').popover();

		// load existing Cfps
		$.getJSON('/call-for-paper-webapp/cfp', function(data) {
			model.cfps(data.cfp);
		});
	});

})(this.jQuery, this.ko);