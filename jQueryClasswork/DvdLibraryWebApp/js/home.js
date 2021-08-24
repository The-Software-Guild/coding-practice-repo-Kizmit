$(document).ready(function () {
    loadDvds();
});

function loadDvds() {
    //clearContactTable();
    var contentRows = $('#DvdContentRows');

    $.ajax({
        type: 'GET',
        url: 'https://tsg-dvds.herokuapp.com/dvds',
        success: function(dvdArray) {
            $.each(dvdArray, function(index, dvd){
                var title = dvd.title;
                var releaseYear = dvd.releaseYear;
                var director = dvd.director;
                var rating = dvd.rating;
                var notes = dvd.notes;
                var dvdId = dvd.dvdId;

                var row = '<tr>';
                    row += '<td>' + title + '</td>';
                    row += '<td>' + releaseYear + '</td>';
                    row += '<td>' + director + '</td>';
                    row += '<td>' + rating + '</td>';
                    row += '<td><button type="button" class="btn btn-info"><a onclick="showEditForm('+dvdId+')">Edit</button></td>';
                    row += '<td><button type="button" class="btn btn-danger" onclick = "deleteContact('+dvdId+')">Delete</button></td>';
                    row += '</tr>';
                
                contentRows.append(row);
            })
        },
        error: function() {
            $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'})
            .text('Error calling web service. Please try again later.'));
        }
    })
}