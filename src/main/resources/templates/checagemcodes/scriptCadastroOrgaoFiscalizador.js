const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Idescricao = document.querySelector(".descricao");

function cadastrar(){
    fetch("http://localhost:8080/cadastrarOrgaoFiscalizador",
        {
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                                    nome: Inome.value,
                                    descricao: Idescricao.value})
        })
        .then(function(res){console.log(res)})
        .catch(function(res){console.log(res)})
};

formulario.addEventListener('submit', function(event){
    event.preventDefault();
    cadastrar();
});