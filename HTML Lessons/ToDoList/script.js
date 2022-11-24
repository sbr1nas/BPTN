let add_todo_form = document.getElementById('add_todo_form');
let todo_stats = document.getElementById('todo_stats');
let todo_table = document.getElementById('todo_table');
let todo_table_body = document.getElementById('todo_table_body');
let index = 0;
add_todo_form.addEventListener('submit', function(e) {
    e.preventDefault();
    let todo_text = document.getElementById('todo_text').value;
    
    if (todo_text.length > 0) {
        let todo_row = document.createElement('tr');
        if(index%2 === 0){
            todo_row.className = "bg-blue-50";
        }else{
            todo_row.className = "bg-blue-100";
        }
       
        let todo_index_td = document.createElement('td');
        let todo_text_td = document.createElement('td');
        let todo_action_td = document.createElement('td');
        let todo_delete_button = document.createElement('button');

        todo_index_td.className = 'px-1 py-2 text-blue-800';
        todo_index_td.innerHTML = ++index;

        todo_text_td.className = 'px-1 py-2 text-blue-800';
        todo_text_td.innerHTML = todo_text;
        todo_delete_button.className = 'todo_delete_button';
        todo_delete_button.innerHTML = 'X';
        todo_delete_button.addEventListener('click', function() {
            todo_row.remove();
            index--;
            if(index === 0){
                todo_table_body.innerHTML = '<tr class="bg-blue-100"><td class="text-center  px-1 py-2 text-blue-800" colspan="3">No Todos found. Add a few items...</td></tr>';
            }
        }
        );
        todo_row.appendChild(todo_index_td);
        todo_row.appendChild(todo_text_td);
        todo_action_td.appendChild(todo_delete_button);
        todo_row.appendChild(todo_action_td);
        if(index === 1){
            todo_table_body.innerHTML = "";
        }
        todo_table_body.appendChild(todo_row);
        document.getElementById('todo_text').value = '';
    }
}
);