function validatesesion() {
    let user = sessionStorage.getItem("user");
    let userJS = JSON.parse(user);
    if(user == null) {
        location.href = "index.html"; 
    } else{
        if(userJS.type === "COORD") {
            $("#nameuser").html(userJS.name);
            $(".useradm").show(true);
            enableSwitch();
            loadOrders(userJS);
        }else {
            alert("Ud no tiene permisos para esta funcionalidad");            
        }
    }    
}

function enableSwitch(){
    $("input[data-bootstrap-switch]").each(function(){
        $(this).bootstrapSwitch('state', $(this).prop('checked'));
      })
}

function loadOrders(user) {
    $.ajax({
        url: "http://" + server + "/api/order/zona/"+user.zone,
        type: 'GET',
        dataType: 'json',

        success: function (respuesta) {
            console.log(respuesta);
            listaOrdenes(respuesta);
        },

        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function listaOrdenes(ordenes) {
    var $tabla = $("#Tabla-Orders");
    $tabla.html("");
    for (let i = 0; i < ordenes.length; i++) {
        var $tr = $("<tr></tr>");
        var stringDate= ordenes[i].registerDay;
        if(stringDate) {
            stringDate = new Date(ordenes[i].registerDay).toLocaleDateString("en-US");
        } else{
            stringDate = "";
        }
        if(ordenes[i].status == "Aprobada")
        {
            $td = $(
                `<td><span class=\"id\">${ordenes[i].id}</span></td>
                <td><span class=\"identificación\">${stringDate}</span></td>
                <td><span class=\"nombre\">${ordenes[i].salesMan.name}</span></td>
                <td>          
                <input type="checkbox" name="my-checkbox" checked data-bootstrap-switch data-off-color="danger" data-on-color="success" onchange="handleClick(this,${ordenes[i].id})">
                </td>
                `);
        }else {
            $td = $(
                `<td><span class=\"id\">${ordenes[i].id}</span></td>
                <td><span class=\"identificación\">${stringDate}</span></td>
                <td><span class=\"nombre\">${ordenes[i].salesMan.name}</span></td>
                <td>          
                <input type="checkbox" name="my-checkbox" data-bootstrap-switch data-off-color="danger" data-on-color="success" onchange="handleClick(this,${ordenes[i].id})">
                </td>
                `);
        }
        $tr.append($td);
        $tabla.append($tr);

        enableSwitch();
    }
}


function handleClick(cb,ordenid) {
    console.log("Clicked, new value = " + cb.checked);
    loadOrder(cb.checked,ordenid);
  }

function cerrarsesion() {
    sessionStorage.removeItem("user");
    location.href = "index.html";
}

function loadOrder(aprobada,id) {
    $.ajax({
        url: "http://" + server + "/api/order/"+id,
        type: 'GET',
        dataType: 'json',

        success: function (respuesta) {
            console.log(respuesta);
            if(respuesta.status!= aprobada){
                if(aprobada){
                    respuesta.status = "Aprobada";
                }else{
                    respuesta.status = "Rechazada";
                }
            }
            saveorder(respuesta);
        },

        error: function (xhr, status) {
            console.log(status);
        }
    });
}

function saveorder(orden) {
    let dataToSend = JSON.stringify(orden);
    $.ajax({
      //url: "/api/order/new",
      url: "http://localhost:8080/api/order/update",
      type: "PUT",
      data: dataToSend,
      datatype: "JSON",
      contentType: "application/json",
      success: function (order) {
        console.log("Estado actualizado correctamente");
      },
      error: function (jqXHR, textStatus, errorThrown) {
        console.log("Error guardando estado");
      },
    });
}