//function fill(elem, text) {
//
//}

const fill = (elem, text) => {
    if (elem.value == "") {
        elem.value = text;
    }
    elem.focus();
    elem.select();
}