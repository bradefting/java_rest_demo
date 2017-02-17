'use strict';

$(document).ready(function() {
  const $table = $('#table');
  const $post = $('#post_button');

  $post.click(() => {
    let data = {
      name: $('#post_name').val(),
      email: $('#post_email').val(),
      phone: $('#post_phone').val(),
      street: $('#post_street').val(),
      city: $('#post_city').val(),
      state: $('#post_state').val(),
      zip: $('#post_zip').val()
    };

    $.ajax({
      type: 'POST',
      url: `http://localhost:8080/customers`,
      processData: false,
      data: JSON.stringify(data),
      dataType: 'json',
      contentType: 'application/json',
      context: document.body
    }).done(() => {
      location.reload();
    });
  });

  $.getJSON('/customers')
    .done((customers) => {
      console.log(customers);
      for (let i=0;i < customers.length;i++) {
        $table.append(`<tr id="tr${customers[i].id}"><td>${customers[i].id}</td><td>${customers[i].name}</td><td>${customers[i].email}</td><td>${customers[i].phone}</td><td>${customers[i].street}</td><td>${customers[i].city}</td><td>${customers[i].state}</td><td>${customers[i].zip}</td><td><a id="edit${customers[i].id}" class="btn-floating waves-effect waves-light red"><i class="material-icons">mode_edit</i></a></td><td><a id="delete${customers[i].id}" class="btn-floating waves-effect waves-light red"><i class="material-icons">clear</i></a></td></tr>`);

        $(`#edit${customers[i].id}`).click(() => {
          $(`#tr${customers[i].id}`).empty().append(`<td>${customers[i].id}</td><td class="input-field"><input id="inNam${customers[i].id}" value="${customers[i].name}" type="text"></td><td class="input-field"><input id="inEma${customers[i].id}" value="${customers[i].email}" type="text"></td><td class="input-field"><input id="inPho${customers[i].id}" value="${customers[i].phone}" type="text"></td><td class="input-field"><input id="inStr${customers[i].id}" value="${customers[i].street}" type="text"></td><td class="input-field"><input id="inCty${customers[i].id}" value="${customers[i].city}" type="text"></td><td class="input-field"><input id="inSta${customers[i].id}" value="${customers[i].state}" type="text"></td><td class="input-field"><input id="inZip${customers[i].id}" value="${customers[i].zip}" type="text"></td><td><a id="post${customers[i].id}" class="btn-floating waves-effect waves-light red"><i class="material-icons">send</i></a></td><td><a id="delete${customers[i].id}" class="btn-floating waves-effect waves-light red disabled"><i class="material-icons">clear</i></a></td>`).appendTo(`#tablehead`);

          $(`#post${customers[i].id}`).click(() => {
            let thisData = {
              id: customers[i].id,
              name: $(`#inNam${customers[i].id}`).val(),
              email: $(`#inEma${customers[i].id}`).val(),
              phone: $(`#inPho${customers[i].id}`).val(),
              street: $(`#inStr${customers[i].id}`).val(),
              city: $(`#inCty${customers[i].id}`).val(),
              state: $(`#inSta${customers[i].id}`).val(),
              zip: $(`#inZip${customers[i].id}`).val()
            };

            $.ajax({
              type: 'PATCH',
              url: `/customers/${customers[i].id}`,
              processData: false,
              data: JSON.stringify({
                id: customers[i].id,
                name: $(`#inNam${customers[i].id}`).val(),
                email: $(`#inEma${customers[i].id}`).val(),
                phone: $(`#inPho${customers[i].id}`).val(),
                street: $(`#inStr${customers[i].id}`).val(),
                city: $(`#inCty${customers[i].id}`).val(),
                state: $(`#inSta${customers[i].id}`).val(),
                zip: $(`#inZip${customers[i].id}`).val()
              }),
              dataType: 'json',
              contentType: 'application/json',
              context: document.body
            }).done(() => {
              location.reload();
            });

          });

        });

        $(`#delete${customers[i].id}`).click(() => {
          $.ajax({
            type: 'DELETE',
            url: `http://localhost:8080/customers/${customers[i].id}`,
            context: document.body
          }).done(() => {
            location.reload();
          });

        });
      }

    })
    .fail(() => {
      Materialize.toast('Unable to retrieve messages', 3000);
    });

});
