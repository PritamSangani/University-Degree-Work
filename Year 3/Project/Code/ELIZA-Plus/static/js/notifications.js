let currentNotifications = [];

$(document).ready(function () {
	/*
	 * Checks every seconds
	 */
	setInterval(function () {
		for (let i = 0; i < currentNotifications.length; i++) {
			refreshNotifications();
		}
	}, 1000);
});

/*
 * Creates info notification so one color
 */
function createInfoNotification(message, seconds) {
	createNotification(message, "info", seconds);
}
/*
 * Creates error notification so one color
 */
function createNegativeNotification(message, seconds) {
	createNotification(message, "negative", seconds);
}
/*
 * Creates positive notification so one color
 */
function createPositiveNotification(message, seconds) {
	createNotification(message, "positive", seconds);
}
/*
 * Creates notification. It creates and stores the new
 * object in the master list of them.
 * Appends the html to the notification section
 */
function createNotification(message, type, seconds) {
	currentNotifications.push({
		message: message,
		cyclesRemaining: seconds,
		type: type
	});
	let typeClass = "";
	let typeText = "";

	if (type === "positive") {
		typeClass = "positive-notification";
		typeText = "dark-text";
	} else if (type === "negative") {
		typeClass = "negative-notification";
		typeText = "light-text";
	} else {
		typeClass = "info-notification";
		typeText = "dark-text";
	}

	let html = `<div class="notification-wrapper ${typeClass}"><p class="notification-text ${typeText}">${message}</p></div>`;

	$("#notification-area").append(html);
}
/*
 * Refresh notifications
 * Subtracts the cycles (1 second a cycle), if 0
 * hides the notification.
 */
function refreshNotifications() {
	let html = '';
	for (let i = 0; i < currentNotifications.length; i++) {

		let typeClass = "";
		let typeText = "";

		if (currentNotifications[i].type === "positive") {
			typeClass = "positive-notification";
			typeText = "dark-text";
		} else if (currentNotifications[i].type === "negative") {
			typeClass = "negative-notification";
			typeText = "light-text";
		} else {
			typeClass = "info-notification";
			typeText = "dark-text";
		}

		let currentNotificationHTML = '<div class="notification-wrapper ' + typeClass + '"><p class="notification-text ' + typeText + '">' + currentNotifications[i].message + '</p></div>';

		if (currentNotifications[i].cyclesRemaining > 0) {
			// console.log(currentNotifications[i]);
			currentNotifications[i].cyclesRemaining--;
			html += currentNotificationHTML;
		}
	}

	$("#notification-area").html(html);
}