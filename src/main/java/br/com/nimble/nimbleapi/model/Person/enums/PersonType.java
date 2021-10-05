package br.com.nimble.nimbleapi.model.Person.enums;

public enum PersonType {
    FISICA("Física"),
    JURIDICA("Juridica"),
    FUNCIONARIO("Funcionário"),
    EMPRESA("Empresa"),
    USUARIO("Usuário");

    private final String typesPerson;

    PersonType(String individualTypes) {
        this.typesPerson = individualTypes;
    }

    public String getTypesPerson() {
        return this.typesPerson;
    }
}
