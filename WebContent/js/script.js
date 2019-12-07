// Include form validation functions here
function validation() {
		var movieTitle = document.forms["form"]["title"].value;
		if(movieTitle== "") {
		alert("Title is Required");
		return false;
		}
		if ((movieTitle.length < 2) || (movieTitle.length > 100)) {
        alert("Title should have 2 to 100 characters.");
        return false;
		}
		var movieGross = document.forms["form"]["boxOffice"].value;
		if(movieGross== "") {
        alert("Gross is required.");
		return false;
		}
		if(/[^0-9]/.test(movieGross)) {
        alert("Gross has to be a number.");
		return false;
		}
		var launchDate = document.forms["form"]["dateOfLaunch"].value;
		if(launchDate== "") {
        alert("Date of Launch is required.");
		return false;
		}
		var movieGenre = document.forms["form"]["genre"].value;
		if(movieGenre== "") {
        alert("Genere is required.");
        return false;
		}
		}
