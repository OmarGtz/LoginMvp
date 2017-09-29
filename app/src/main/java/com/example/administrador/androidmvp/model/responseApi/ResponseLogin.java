package com.example.administrador.androidmvp.model.responseApi;

import com.google.gson.annotations.SerializedName;


public class ResponseLogin {

    @SerializedName("Respuesta")
    private boolean respuesta;
    @SerializedName("ClaveAplicacion")
    private String claveAplicacion;
    @SerializedName("UsuarioId")
    private String usuarioId;
    @SerializedName("Nombre")
    private String  nombre;
    @SerializedName("ApellidoPaterno")
    private String apePaterno;
    @SerializedName("ApellidoMaterno")
    private String apeMaterno;
    @SerializedName("CorreoElectronico")
    private String correoElectronico;
    @SerializedName("Password")
    private String password;
    @SerializedName("ImagenURL")
    private String imagen;
    @SerializedName("Telefono")
    private String telefono;
    @SerializedName("SexoId")
    private int sexoId;
    @SerializedName("FechaNacimiento")
    private String fechaNacimiento;

    public ResponseLogin(boolean respuesta, String claveAplicacion, String usuarioId, String nombre, String apePaterno, String apeMaterno, String correoElectronico, String password, String imagen, String telefono, int sexoId, String fechaNacimiento) {
        this.respuesta = respuesta;
        this.claveAplicacion = claveAplicacion;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.imagen = imagen;
        this.telefono = telefono;
        this.sexoId = sexoId;
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public String getClaveAplicacion() {
        return claveAplicacion;
    }

    public void setClaveAplicacion(String claveAplicacion) {
        this.claveAplicacion = claveAplicacion;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getSexoId() {
        return sexoId;
    }

    public void setSexoId(int sexoId) {
        this.sexoId = sexoId;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "ResponseLogin{" +
                "respuesta=" + respuesta +
                ", claveAplicacion='" + claveAplicacion + '\'' +
                ", usuarioId='" + usuarioId + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apePaterno='" + apePaterno + '\'' +
                ", apeMaterno='" + apeMaterno + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", password='" + password + '\'' +
                ", imagen='" + imagen + '\'' +
                ", telefono='" + telefono + '\'' +
                ", sexoId=" + sexoId +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}
