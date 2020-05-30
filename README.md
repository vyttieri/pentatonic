Pentatonic
===============

Design
------
Three layers of abstraction:
Layer 0 is the midi layer: follows the MIDI spec as best possible, outputs .mid files in correct format

LayerOne
------
```
Piece("My MIDI Piece", "4/4", "60bpm",
  Instrument("Trumpet") {
    Bar1("A4 quarter", "C4 quarter", "E4 quarter", "D4 quarter")
  },
  Instrument("Piano") {
    Bar1("A2 half", "G2 half")
  }
)
```


Acknowledgments
---------------
- Information on MIDI format from http://www.ccarh.org/courses/253/handout/smf/ and http://www.music.mcgill.ca/~ich/classes/mumt306/StandardMIDIfileformat.html#BM2_1, as well as the official Complete MIDI Specification from https://www.midi.org
Standard MIDI Format specification from https://www.midi.org
- Inspiration for classes & code structure taken from https://github.com/MarkCWirt/MIDIUtil, https://github.com/mido/mido
- Scala knowledge from https://scala-lang.org, https://alvinalexander.com, https://geeksforgeeks.org, and of course https://stackoverflow.com

TODO
----
- Cleaner way to write bytes, perhaps https://stackoverflow.com/questions/48926339/scala-hex-literal-for-bytes
