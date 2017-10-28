package textbasedadventure.game;

enum Commands {
    ;

    enum GO {
        EAST, WEST, SOUTH, NORTH, IN, OUT, LEFT, RIGHT, STRAIGHT, BACK, DOWN, UP
    }

    enum PICKUP {
        KEY, NOTE, TORCH, SUNDIAL, ARTIFACT, ELIXIR, PIECE
    }

    enum OPEN {
        DOOR, CHEST, HATCH
    }

    enum START {
        GAME
    }

    enum LOAD {
        GAME
    }

    enum LOOK {
        AROUND
    }

    enum SHOW {
        INVENTORY
    }

    enum USE {
        RUSTYKEY, SILVERKEY, GOLDENKEY, TORCH, ELIXIR
    }

    enum TURN {
        WHEEL
    }

    enum PULL {
        BOOK
    }

    enum EXAMINE {
        KEY, TORCH, TREE, SUNDIAL, HOLE, CHEST, NOTE, PLAINNOTE, TORNNOTE, MUDPIT, CORPSE, WATER, WHEEL, HATCH, PARCHMENT, STATUE, ALTAR, BOOKSHELF, BOOK, STAND, ARTIFACT, CIRCULARARTIFACT, TRIANGULARARTIFACT, RECTANGULARARTIFACTROCK, OLDMAN, ELIXIR, SILVERKEY, RUSTYKEY, GOLDENKEY
    }
}
