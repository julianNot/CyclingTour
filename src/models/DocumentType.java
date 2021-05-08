package models;

public enum DocumentType {
    PASSPORT( "Pasaporte" ),
    CITIZENSHIP_ID("Cedula de Ciudadania"),
    FOREIGNER_ID("Cedula de Extranjeria");

    private String label;

    DocumentType( String label ){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
