var btnSignin = document.querySelector("#signin");
var btnSignup = document.querySelector("#signup");
var body = document.querySelector("body");

var checkbocMedico =  document.getElementById("check-doctor");
var checkbocFuncionario =  document.getElementById("check-employee");

btnSignin.addEventListener("click", function (){
   body.className = "sign-in-js";
});

btnSignup.addEventListener("click", function (){
    body.className = "sign-up-js";
});
//Mostrar o crm
function ShowHideDiv(chkCrm) {
    var dvCrm = document.getElementById("crm");
    dvCrm.style.display = chkCrm.checked ? "block" : "none";
    if(dvCrm.style.display == "block"){
        checkbocFuncionario.disabled = true;
    }else {
        checkbocFuncionario.disabled = false;
    }
}
function ShowHideDiv2(chkCrm) {
    var dvCrm = document.getElementById("crm");
    dvCrm.style.display = chkCrm.checked ? "block" : "none";
    if(dvCrm.style.display == "block"){
        checkbocMedico.disabled = true;
    }else {
        checkbocMedico.disabled = false;
    }
}


//navbar
