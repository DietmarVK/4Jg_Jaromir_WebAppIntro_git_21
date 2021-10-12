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
        .then(response => response.text())  // .text() for Plaintext, .json() for JSON
        .then(tableData => document.getElementById("tableContent").innerHTML = tableData)
        .catch(err => console.error(err));
}

const fetchServlet = () => {
    let url = "TestServlet";
    let lastname = document.getElementById("lastname").value;
    fetch(url, {
        method: "POST",
        headers: { "Content-Type" : "application/x-www-form-urlencoded"},
        body: "lastname=" + lastname //+ "&firstname=" + firstname
    }) // init nur wenn POST oder spezielle Header
        //.then(response => response.text())
        //.then(responseData => document.getElementById("responseFromServlet").innerHTML = responseData)
        //.catch(err => console.error(err));
        .then(response => response.json())
        .then(jsonObj => processJson(jsonObj))
        .catch(err => console.error(err));
}
const processJson = (jsonObj) => {
    resultStr = jsonObj[0].nickname + "(" + jsonObj[0].email + ")";
    document.getElementById("responseFromServlet").innerHTML = resultStr;
}