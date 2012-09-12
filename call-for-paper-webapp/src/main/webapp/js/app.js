(function($, ko) {

	// Class to represent a Paper entry.
	function Paper(sessionType, submitterEmail, sessionTitle, sessionSummary, speakers, speakersBios) {
		var self = this;
		self.sessionType = sessionType;
		self.submitterEmail = submitterEmail;
		self.sessionTitle = sessionTitle;
		self.sessionSummary = sessionSummary;
		self.speakers = speakers;
		self.speakersBios = speakersBios;
	}

	// ViewModel for Knockout
	function AppViewModel() {
		var self = this;
		// For Papers list
		self.papers = ko.observableArray([]);
		self.selectedPaper = ko.observable({});
		self.selectedPaperVotes = ko.observable({
			ok : 0,
			ko : 0
		});
		self.selectPaper = function(paper) {
			self.selectedPaper(paper);
			var voteValues = {
				ok : 0,
				ko : 0
			};
			$.getJSON('vote?paperid=' + paper.id, function(votes) {
				votes.vote.map(function(vote) {
					if (vote.choice) {
						voteValues.ok += 1;
					} else {
						voteValues.ko += 1;
					}
				});
			}).complete(function() {
				self.selectedPaperVotes(voteValues);
			});

		};

		// For a new Paper
		self.availableSessionTypes = ko.observableArray([ 'Conference', 'Tool In Action', 'Quickie' ]);
		self.sessionType = ko.observable('Quickie');
		self.submitterEmail = ko.observable('');
		self.sessionTitle = ko.observable('');
		self.sessionSummary = ko.observable('');
		self.speakers = ko.observable('');
		self.speakersBios = ko.observable('');
		self.talkSubmitted = ko.observable(false);

		// Submit a new Paper
		self.postPaper = function() {
			var data = ko.toJSON({
				"paper" : new Paper(self.sessionType, self.submitterEmail, self.sessionTitle, self.sessionSummary,
						self.speakers, self.speakersBios)
			});
			$.ajax({
				url : "paper",
				type : "POST",
				data : data,
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function() {
					// update flags
					self.talkSubmitted(true);
					// clear form
					self.sessionType('Quickie');
					self.submitterEmail('');
					self.sessionTitle('');
					self.sessionSummary('');
					self.speakers('');
					self.speakersBios('');
				}
			});
		};
	}
	// Apply bindings
	var model = new AppViewModel();
	ko.applyBindings(model);

	// When document is ready ...
	$(document).ready(function() {

		// init Twitter Bootstrap popover.
		$('#sessionTypeDetails').popover();

		// load existing Papers
		$.getJSON('paper?state=ACCEPTED', function(data) {
			model.papers(data.paper);
		});
	});

})(jQuery, ko);