var btnSignin = document.querySelector("#signin");
var btnSignup = document.querySelector("#signup");
var body = document.querySelector("body");

var checkbocMedico =  document.getElementById("medico");
var checkbocFuncionario =  document.getElementById("funcionario");

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
    console.log(chkCrm);
    var test = chkCrm.checked ? "medico" : "funcionario";
    if(dvCrm.style.display == "block" && test == "medico"){
        checkbocFuncionario.disabled = true;

    }else if(dvCrm.style.display == "block" ){
        checkbocMedico.disabled = true;
    }else{
        checkbocFuncionario.disabled = false;
        checkbocMedico.disabled = false;
    }




}
