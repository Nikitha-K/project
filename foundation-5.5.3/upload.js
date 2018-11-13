
var data = [];
data = JSON.parse(localStorage.getItem("formdata"));

function uploadcsv() {
    var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv|.txt)$/;
    if (regex.test($("#fileUpload").val().toLowerCase())) {
        if (typeof (FileReader) != "undefined") {
            var reader = new FileReader();
            reader.onload = function (e) {
               
                var rows = e.target.result.split("\r\n");
                for (var i = 0; i < rows.length; i++) {
                    var cells = rows[i].split(",");

                    if (cells.length == 3) {
                      
                        var customer = {};
                        customer.name = cells[0];
                        customer.mobile = cells[1];
                        customer.mail = cells[2];
                        b = validform(cells[0],cells[1],cells[2]);
                        if (b) {
                            data.push(customer);
                        }

                    }
                }
                var table=ConvertToTable(false);
             
                localStorage.setItem("formdata", JSON.stringify(data));
               
                $("#dataupload").append(table);

            }
            reader.readAsText($("#fileUpload")[0].files[0]);
        } else {
            alert("This browser does not support HTML5.");
        }
    } else {
        alert("Please upload a valid CSV file.");
    }

  
}
