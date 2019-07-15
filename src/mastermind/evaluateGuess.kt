package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition =0;
    var wrongPosition =0;
    val comparados = mutableListOf<Int>();

    for(i in 0..3)
    {
        for(j in 0..3)
        {

            if(secret[i] == guess[j]) //achou
            {
              if(!comparados.contains(j)) { //Se não for um elemento que já foi comparados antes..

                  if (i == j) { //ta na posição correta
                      rightPosition++;
                      comparados.add(j);
                      break;

                  } else {
                      if(!(guess[j] == secret[j]) && !(secret[i] == guess[i]))
                      {
                          wrongPosition++;
                          comparados.add(j);
                          break;
                      }

                  }
              }
            }
        }
    }



    var Evaluation = Evaluation(rightPosition, wrongPosition);
    return Evaluation;
}
