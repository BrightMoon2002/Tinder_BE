let currentUser = JSON.parse(localStorage.getItem("user"));
if(currentUser == null || currentUser.accessToken == null){
    window.location.href = "/viewWS/login.html";
}
successHandler();

function createProduct() {
    let name_product = $('#name_product').val();
    let date = $('#date').val();
    let quantity = $('#quantity').val();
    let image = $('#image')[0].files[0];
    let type = $('#type').val();
    let dataForm = new FormData();
    let form = {
        nameProduct: name_product,
        date: date,
        quantity: quantity,
        type: {
            id: type
        }
    }
    dataForm.append("form", JSON.stringify(form));
    dataForm.append("image", image);
    $.ajax({
        headers:{
            'Authorization': 'Bearer ' + currentUser.accessToken
        },
        url: "http://localhost:8080/api/products",
        type: "POST",
        data: dataForm,
        contentType: false,
        processData: false,
        enctype: 'multipart/form-data',
        cache: false,
        success: successHandler
    })
    hideModal();
    function1();
}


function openAddModal() {
    openModal();
}

function openModal() {
    $('#myModal').modal("show");
    $.ajax({
        type: "GET",
        headers:{
            'Authorization': 'Bearer ' + currentUser.accessToken
        },
        async: false,
        url: "http://localhost:8080/api/types/",
        success: function (types) {
            if (types) {
                let listTypes = [];
                listTypes = types;
                let userSelect = document.getElementById("type");
                listTypes.forEach(function (option) {
                    var opt = document.createElement('option');
                    opt.value = option.id;
                    opt.innerHTML = option.nameType;
                    userSelect.appendChild(opt);
                })
            }
        }
    })
    function1();
    // $('body').removeClass('modal-open');
    // $('.modal-backdrop').remove();
}

function hideModal() {
    $('#myModal').modal('hide');
    $('body').removeClass('modal-open');
    $('.modal-backdrop').remove();
}

function getAllProduct(data) {
    return `
                <tr> <td>${data.nameProduct}</td>
            <td>${data.date}</td>
            <td>${data.quantity}</td>
            <td>${data.type.nameType}</td>
            <td>
                <img height="100" width="100" src="../img/${data.image}"></img>
            </td>
            <td>
                <button class="btn btn-info add-new" onclick="deleteProduct(this)" value="${data.id}">Xóa</button>
                <button type="button" class="btn btn-info add-new" data-target="#myModal1" data-toggle="modal"
                        onclick="showFormEdit(this)" value="${data.id}"><i class="fa fa-plus"></i> Edit
                </button>
            </td>
            </tr>
            `
}

function deleteProduct(a) {
    let id = a.getAttribute("value");
    $.ajax({
        type: "DELETE",
        headers:{
            'Authorization': 'Bearer ' + currentUser.accessToken
        },
        async: false,
        url: "http://localhost:8080/api/products/" + id,
        success: successHandler
    })
    function1();

}

function successHandler() {
    $.ajax({
        type: "GET",
        async: false,
        headers:{
            'Authorization': 'Bearer ' + currentUser.accessToken
        },
        url: "http://localhost:8080/api/products/",
        success: function (data) {
            let content = ' <table class="table"><thead>\n' +
                '        <tr>\n' +
                '            <th scope="col">Tên sản phẩm</th>\n' +
                '            <th scope="col">Ngày nhập</th>\n' +
                '            <th scope="col">Số lượng</th>\n' +
                '            <th scope="col">Thể loại</th>\n' +
                '            <th scope="col">Hình Ảnh</th>\n' +
                '        </tr>\n' +
                '        </thead><tbody>';
            for (let i = 0; i < data.length; i++) {
                content += getAllProduct(data[i]);
            }
            content += `</tbody></table>`
            document.getElementById('list').innerHTML = content;
            function1();
        }
    })
}

function showFormEdit(a) {
    let idProduct = a.getAttribute("value");
    $.ajax({
        type: "GET",
        headers:{
            'Authorization': 'Bearer ' + currentUser.accessToken
        },
        async: false,
        url: "http://localhost:8080/api/types/",
        success: function (types) {
            if (types) {
                let listTypes = [];
                listTypes = types;
                let userSelect = document.getElementById("type1");
                listTypes.forEach(function (option) {
                    var opt = document.createElement('option');
                    opt.value = option.id;
                    opt.innerHTML = option.nameType;
                    userSelect.appendChild(opt);
                })
                $.ajax({
                    type: "GET",
                    headers:{
                        'Authorization': 'Bearer ' + currentUser.accessToken
                    },
                    url: "http://localhost:8080/api/products/" + idProduct,
                    async: false,
                    success: function (product) {
                        if (product) {
                            $('#name_product1').val(product.nameProduct);
                            $('#date1').val(product.date);
                            $('#quantity1').val(product.quantity);
                            $('#idProduct').val(product.id);
                            $('#oldFileName').val(product.image);
                            $('#myModal1').modal("show");
                        }
                    }
                })
            }
        }
    }).fail(function () {
        window.location.href = "/viewWS/login.html";
    })
    function1();
}
function function1(event){
    event.preventDefault();
}

function editProduct() {
    let id = $('#idProduct').val();
    let name_product = $('#name_product1').val();
    let date = $('#date1').val();
    let quantity = $('#quantity1').val();
    let image = $('#image1')[0].files[0];
    let type = $('#type1').val();
    let dataForm = new FormData();
    let form = {
        id: id,
        nameProduct: name_product,
        date: date,
        quantity: quantity,
        type: {
            id: type
        }
    }
    dataForm.append("form", JSON.stringify(form));
    dataForm.append("image", image);
    $.ajax({
        headers:{
            'Authorization': 'Bearer ' + currentUser.accessToken
        },
        url: "http://localhost:8080/api/products/" + id,
        type: "PUT",
        data: dataForm,
        contentType: false,
        processData: false,
        enctype: 'multipart/form-data',
        cache: false,
        success: successHandler
    })
    $('#myModal1').modal('hide');
    $('body').removeClass('modal-open');
    $('.modal-backdrop').remove();
    function1();
}

function findProduct() {
    let input = $('#key').val();
    $.ajax({
        headers:{
            'Authorization': 'Bearer ' + currentUser.accessToken
        },
        url: "http://localhost:8080/api/products/find/" + input,
        type: "GET",
        success: function (data) {
            console.log("abc")
        }
    })
}
