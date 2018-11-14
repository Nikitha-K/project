


function ConvertToCSV() {

  var jData;
  jData = JSON.parse(localStorage.getItem("formdata"));
  if(jData!=null){
  var delimiter = ',';
  var fileName = "mydata";
  var ShowHeader = true;
  var title = "";
  var strCSV = '';
  var arrJSON = typeof jData != 'object' ? JSON.parse(jData) : jData;
  var strCSV = '';

  if (title.length > 0)
    strCSV += title + '\r\n\n';
  if (ShowHeader) {
    var headerRow = "";
    for (var index in arrJSON[0]) {
      if (headerRow != '') headerRow += delimiter;
      headerRow += index;
    }
    strCSV += headerRow + '\r\n';
  }
  for (var i = 0; i < arrJSON.length; i++) {
    var sLine = '';
    for (var index in arrJSON[i]) {
      if (sLine != '') sLine += delimiter;
      sLine += arrJSON[i][index];
    }
    strCSV += sLine + '\r\n';
  }
  if (strCSV == '') {
    console.log('Error while converting due to invalid data');
    return;
  }
  var uri = 'data:text/csv;charset=utf-8,' + encodeURI(strCSV);
  var link = document.createElement("a");
  link.href = uri;
  link.style = "visibility:hidden";
  link.download = fileName + ".csv";
  $('body').append(link);
  link.click();
  $('body').remove(link);
}else{
  alert("data is empty");
}
}

