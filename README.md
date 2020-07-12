# todo

a simple CLI tool to maintain a todo.txt file

## Installation

1) git clone https://github.com/PrasannaGnanaraj/todo-cli.git
2) lein uberjar
3) lein bin

## Usage

### Set TODO_LOCATION

$ export TODO_LOCATION="desired_file_path/todo.txt"

### To add a todo

$ todo a "new task"

### To view all todos

$ todo ls

## Options

 a "add a new todo"
 ls "list all todos"

## License

Copyright © 2020 Gnana Prasanna Gnanaraj

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
