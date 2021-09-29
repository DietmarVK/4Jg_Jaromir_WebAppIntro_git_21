const fill = (elem, text) => {
    if (elem.value == "") {
        elem.value = text;
    }
    elem.focus();
    elem.select();
}

const validate = (formElem) => {
    let ok = true;
    let firstname = formElem.firstname.value;
    if (firstname == "" || firstname.length < 3 || firstname.length > 20) {
        ok = false;
        document.getElementById("errFirstname").innerHTML = "* please enter firstname";
    } else {
        document.getElementById("errFirstname").innerHTML = "";
    }

    let lastname = formElem.lastname.value;
    if (lastname == "" || lastname.length < 3 || lastname.length > 20) {
        ok = false;
        document.getElementById("errLastname").innerHTML = "* please enter lastname";
    } else {
        document.getElementById("errLastname").innerHTML = "";
    }

    let age = formElem.age.value;
    if (isNaN(age) || age < 1 || age > 120) {
        ok = false;
        document.getElementById("errAge").innerHTML = "* please enter a valid number between 1 and 120";
    } else {
        document.getElementById("errAge").innerHTML = "";
    }
    return ok;
}

const fetchTable = () => {
    let url = "timetable.html";
    fetch(url)
        //.then(function(response) {console.log("HTTP-status: " + response.status)}); //Mit function
        //.then(response => console.log("HTTP-status: " + response.status)); //lambda expression
        .then(response => response.text())
        .then(tableData => document.getElementById("tableContent").innerHTML = tableData);
}