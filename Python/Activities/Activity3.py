player1= input("Enter player1 name")
player2 = input("Enter player2 name")

player1_choice = input("choose from rock ,paper, scissors of player 1")
player2_choice =input("chosse from rock,paper,scissors of player 2")

if (player1_choice==player2_choice):
    print("its a tie")
elif (player1_choice== "rock"):
    if(player2_choice=="scissors"):
        print("player1 wins")
    else:
        print("Player2 wins")
elif (player1_choice== "scissors"):
    if(player2_choice=="paper"):
        print("player1 wins")
    else:
        print("Player2 wins")
elif (player1_choice== "paper"):
    if(player2_choice=="rock"):
        print("player1 wins")
    else:
        print("Player2 wins")
else:
    print("user did not enter valid values")