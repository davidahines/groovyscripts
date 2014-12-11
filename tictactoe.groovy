board = [[" "," "," "],[" "," "," "],[" "," "," "]]
Random random = new Random()

isXFirst = random.nextInt(2)
isXTurn = false;
if(isXFirst == 1){
  isXTurn = 1;
  println "X goes first."
}else{
  println "O goes first."
}
moves = 0
max = 9
winner = "draw"
while(moves < 9){

  printBoard()
  
  def cursor
  if(isXTurn){
    cursor = "x"
  }else{
    cursor = "o"
  }
  
  println "It's ${cursor}'s turn."
  
  
  
  
  row = System.console().readLine "Enter row (starts with 0)"
  column = System.console().readLine "Enter column (starts with 0)"
  


  
  if(row != null && !row.equals("") && 
  column != null && !column.equals("") && 
  row.toInteger() != null && column.toInteger() != null && 
  row.toInteger() < 3 && row.toInteger() >=0 && 
  column.toInteger() <3 && column.toInteger() >=0){
    moves++
    board[row.toInteger()][column.toInteger()] = cursor
  }else{
    if(row == null){
      println "row is null"
      continue
    }
    
    if(column == null){
      println "column is null"
      continue
    }
    
    if(row.equals("")){
      println "row is empty"
      continue
    }
    if(column.equals("")){
      println "column is empty"
      continue
    }
    
    if(row.toInteger() == null){
      println "row is not an integer."
      continue
    }
    if(column.toInteger() == null){
      println "column is not an integer."
      continue
    }

    println "Please enter a number between 0 and 2 for row and column." 
  }
  
  isXTurn = !isXTurn
  winner = hasWinner(board, cursor, row, column);
  if(winner != "FALSE"){
     break
  }
}

if(winner == "draw"){
  println "Draw."
}else if(winner == "" || winner == "o"){
  println "${winner} has won!"   
}else{
  println "It is a draw."
}


def printBoard(){
      // iterate over board        
  println "+-+-+-+"
  for(int i = 0; i < 3; i++){

      for(int j = 0; j < 3; j++){
          if(j %2 == 0){
             print "|"
             }
          print "${board[i][j]}"
          if(j %2 == 0){
             print "|"
             }
          
      }
      println ""  
      println "+-+-+-+"
   }
}
  
def hasWinner(board, cursor,x, y){
   n = 3
   // check column
   for(int i = 0; i < n; i++){
      if(!(board[x.toInteger()][i].toString().equals(cursor)))
          break
      if(i == n-1){
          return cursor
      }
   }
   // check row
   for(int i = 0; i < n; i++){
      if(!board[i][y.toInteger()].toString().equals(cursor))
          break
      if(i == n-1){
          return cursor
      }
   }
   // diagonally
   if(x == y){
      for(int i = 0; i < n; i++){
         if(!board[i][i].toString().equals(cursor))
              break;
         if(i == n-1){
              return cursor
         }
      }
   }
   // opposite direction     
   for(int i = 0;i<n;i++){
      if(!board[i][(n-1)-i].toString().equals(cursor))
         break;
      if(i == n-1){
         return cursor
      }
   }
   return "FALSE"
}