var btnSignin = document.querySelector("#signin");
var btnSignup = document.querySelector("#signup");
var body = document.querySelector("body");

var checkboxMedico = document.querySelector("#medico");
var checkboxFuncionario = document.querySelector("#funcionario");
var checkboxTipo = document.querySelector("#crm");
var cont = true;
btnSignin.addEventListener("click", function (){
   body.className = "sign-in-js";
});

btnSignup.addEventListener("click", function (){
    body.className = "sign-up-js";
});
//Mostrar o crm
;

checkboxMedico.addEventListener("click", function (){
    checkboxTipo.className = "collapseFalse";
    console.log(false);

});

checkboxFuncionario.addEventListener("click", function (){
    checkboxTipo.className = "collapseFalse";

});


