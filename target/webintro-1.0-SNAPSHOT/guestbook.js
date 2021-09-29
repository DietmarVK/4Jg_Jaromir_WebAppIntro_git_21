function onButtonClick() {
    //alert("button successfully clicked");
    //if(confirm("continue?") == true) {
    //    alert("continue");
    //}
    //if(prompt("continue y/n?", "y") == "y") {
    //    alert("continue");
    //}
    // let - block scope
    // const - block scope
    // var - local scope
    // nothing - global scope
    let month1 = new Array("Jan", "Feb", "Mar");
    let month2 = ["Apr", "May", "Jun"];
    let month3 = month1.concat(month2, "Dec");

    alert(month3.sort().join(" - "));

    let v1 = 1;
    let v2 = "1";
    alert(v1 == v2); //true weil nicht auf datentyp geschaut wird
    alert(v1 === v2); //false weil auf datentyp geschaut wird

    alert(isNaN("xy"));

    try {
        blabla(v1 === v2);
    } catch(ex) {
        alert(ex.toString());
    }

    console.log("button clicked");
}