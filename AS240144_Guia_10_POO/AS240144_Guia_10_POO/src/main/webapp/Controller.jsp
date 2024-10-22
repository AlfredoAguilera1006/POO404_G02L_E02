<%@ include file="conexion.jsp" %>
<jsp:useBean id="persona" class="www.udb.edu.sv.beans.PersonaBean"
             scope="request"/>
<jsp:useBean id="ocupacion" class="www.udb.edu.sv.beans.OcupacionBean"
             scope="request"/>
<%@ page import="www.udb.edu.sv.beans.OcupacionBean" %>
<jsp:setProperty name="persona" property="*"/>
<jsp:setProperty name="ocupacion" property="idOcupacion"
                 value="<%=persona.getIdOcupacion() %>"/>
<jsp:setProperty name="ocupacion" property="ocupacion" value="<%=
persona.getNombreOcupacion() %>"/>
<%

        st = conexion.prepareStatement("INSERT INTO persona(nombre_persona,
                edad_persona, telefono_persona, sexo_persona, id_ocupacion, fecha_nac)
        VALUES(?,?,?,?,?,?)");
        st.setString(1, persona.getNombrePersona());
        st.setInt(2, persona.getEdadPersona());
        st.setString(3, persona.getTelefonoPersona());
        st.setString(4, persona.getSexoPersona());
        st.setInt(5, ocupacion.getIdOcupacion());
    st.setString(6, persona.getFechaNac());
    st.executeUpdate();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main
    </title>
    <link rel="stylesheet" href="css/bootstrap1.min.css">
    <link rel="stylesheet" href="css/estilo.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fontawesome/4.7.0/css/font-awesome.min.css">
    <script src="js/jquery-3.2.1.slim.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
     role="navigation">
    <div class="container">
        <a class="navbar-brand" href="#">Guia Bean</a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse"
                data-target="#exCollapsingNavbar">
            &#9776;
        </button>
    </div>
</nav>
<body>
<br>
<br>
<br>
<div class="container">
    <ul class="list-group">
        <li class="list-group-item active" aria-current="true">Datos cargados al bean</li>
        <li class="list-group-item"><strong>
            <jsp:getProperty name="persona" property="nombrePersona"/>
        </strong></li>
        <li class="list-group-item"><strong>
<jsp:getProperty name="persona" property="edadPersona"/>
        </strong></li>
        <li class="list-group-item"><strong>
            <jsp:getProperty name="persona" property="telefonoPersona"/>
        </strong></li>
        <li class="list-group-item"><strong>
            <jsp:getProperty name="persona" property="sexoPersona"/>
        </strong></li>
        <li class="list-group-item"><strong>
            <jsp:getProperty name="persona" property="fechaNac"/>
        </strong></li>
        <li class="list-group-item"><strong>
            <jsp:getProperty name="ocupacion" property="ocupacion"/>
        </strong></li>
    </ul>
</div>
</body>
<footer id="sticky-footer" style="position: absolute;bottom: 0;" class="flex-shrink-0
py-4 bg-dark text-white-50">
    <div class="container text-center ">
        <small style="color: white;">Copyright &copy; BEAN</small>
    </div>
</footer>
</html>