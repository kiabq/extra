import { createSignal, For } from 'solid-js';
import type { Component } from 'solid-js';

const App: Component = () => {
  const [input, setInput] = createSignal<string>('');
  const [items, setItems] = createSignal<string[]>([]);
  const [selected, setSelected] = createSignal<number[]>([]);

  return (
    <div class="w-screen h-screen flex justify-center items-center">
      <div class="max-w-[600px] w-full h-[600px] flex flex-col p-2 gap-y-4 border-solid border-black border-2 rounded-sm bg-white">
        <h1 class="text-2xl text-center p-5">Solid Todo List</h1>
        <form class="flex" onSubmit={(e) => {
          e.preventDefault();
        }}>
          <input 
            type="text"
            name='item'
            placeholder="Add an item" 
            class="p-2 grow"
            onChange={(e) => {
              setInput(e.target.value);
            }}
            value={input()}
          />
          <button
            class="max-w-[250px] mx-auto text-white bg-green-500 p-2"
            type="submit"
            onClick={() => {
              setItems([...items(), input()]);
              setInput('');
            }}
          >
            Add an item
          </button>   
        </form>
        <ul class="flex flex-col gap-y-2 h-full overflow-y-auto">
          {items().length > 0 ?
            <For each={items()}>
              {
                (item, i) => 
                  <li class="flex items-center gap-2">
                    <input 
                      type="checkbox" 
                      class="h-6 w-6"
                      onClick={(e) => {
                        if (e.currentTarget.checked) {
                          setSelected([...selected(), i()]);
                        } else {
                          setSelected(selected().filter((val) => val != i()))
                        }
                      }}
                    />
                    <p class="grow">{item}</p>
                  </li>
              }
            </For>
            :
            <p class='m-auto text-neutral-400'>No Items Found</p>
          }
        </ul>
        {selected().length > 0 && <button 
          class="bg-red-500 text-white p-2 mt-auto"
          onClick={() => {
            if (selected().length > 0) {
              selected().forEach(item => {
                setItems(items().filter((val) => items()[item] != val))
              });
              setSelected([]);
            }
          }}
        >
          Delete
        </button>}
      </div>
    </div>
  );
};

export default App;