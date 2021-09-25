(ns magical-music-machine.constants)

(def notes [{:labels ["C0"]
             :frequency 16.35
             :wavelength 2109.89
             :midi-note 12}
            {:labels ["C#0" "Db0"]
             :frequency 17.32
             :wavelength 1991.47
             :midi-note 13}
            {:labels ["D0"]
             :frequency 18.35
             :wavelength 1879.69
             :midi-note 14}
            {:labels ["D#0" "Eb0"]
             :frequency 19.45
             :wavelength 1774.20
             :midi-note 15}
            {:labels ["E0"]
             :frequency 20.60
             :wavelength 1674.62
             :midi-note 16}
            {:labels ["F0"]
             :frequency 21.83
             :wavelength 1580.63
             :midi-note 17}
            {:labels ["F#0" "Gb0"]
             :frequency 23.12
             :wavelength 1491.91
             :midi-note 18}
            {:labels ["G0"]
             :frequency 24.50
             :wavelength 1408.18
             :midi-note 19}
            {:labels ["G#0" "Ab0"]
             :frequency 25.96
             :wavelength 1329.14
             :midi-note 20}
            {:labels ["A0"]
             :frequency 27.50
             :wavelength 1254.55
             :midi-note 21}
            {:labels ["A#0" "Bb0"]
             :frequency 29.14
             :wavelength 1184.13
             :midi-note 22}
            {:labels ["B0"]
             :frequency 30.87
             :wavelength 1117.67
             :midi-note 23}
            {:labels ["C1"]
             :frequency 32.70
             :wavelength 1054.94
             :midi-note 24}
            {:labels ["C#1" "Db1"]
             :frequency 34.65
             :wavelength 995.73
             :midi-note 25}
            {:labels ["D1"]
             :frequency 36.71
             :wavelength 939.85
             :midi-note 26}
            {:labels ["D#1" "Eb1"]
             :frequency 38.89
             :wavelength 887.10
             :midi-note 27}
            {:labels ["E1"]
             :frequency 41.20
             :wavelength 837.31
             :midi-note 28}
            {:labels ["F1"]
             :frequency 43.65
             :wavelength 790.31
             :midi-note 29}
            {:labels ["F#1" "Gb1"]
             :frequency 46.25
             :wavelength 745.96
             :midi-note 30}
            {:labels ["G1"]
             :frequency 49.00
             :wavelength 704.09
             :midi-note 31}
            {:labels ["G#1" "Ab1"]
             :frequency 51.91
             :wavelength 664.57
             :midi-note 32}
            {:labels ["A1"]
             :frequency 55.00
             :wavelength 627.27
             :midi-note 33}
            {:labels ["A#1" "Bb1"]
             :frequency 58.27
             :wavelength 627.27
             :midi-note 34}
            {:labels ["B1"]
             :frequency 61.74
             :wavelength 558.84
             :midi-note 35}
            {:labels ["C2"]
             :frequency 65.41
             :wavelength 558.84
             :midi-note 36}
            {:labels ["C#2" "Db2"]
             :frequency 69.30
             :wavelength 497.87
             :midi-note 37}
            {:labels ["D2"]
             :frequency 73.42
             :wavelength 469.92
             :midi-note 38}
            {:labels ["D#2" "Eb2"]
             :frequency 77.78
             :wavelength 443.55
             :midi-note 39}
            {:labels ["E2"]
             :frequency 82.41
             :wavelength 418.65
             :midi-note 40}
            {:labels ["F2"]
             :frequency 87.31
             :wavelength 395.16
             :midi-note 41}
            {:labels ["F#2" "Gb2"]
             :frequency 92.50
             :wavelength 372.98
             :midi-note 42}
            {:labels ["G2"]
             :frequency 98.00
             :wavelength 352.04
             :midi-note 43}
            {:labels ["G#2" "Ab2"]
             :frequency 103.83
             :wavelength 352.04
             :midi-note 44}
            {:labels ["A2"]
             :frequency 110.00
             :wavelength 313.64
             :midi-note 45}
            {:labels ["A#2" "Bb2"]
             :frequency 116.54
             :wavelength 296.03
             :midi-note 46}
            {:labels ["B2"]
             :frequency 123.47
             :wavelength 279.42
             :midi-note 47}
            {:labels ["C3"]
             :frequency 130.81
             :wavelength 263.74
             :midi-note 48}
            {:labels ["C#3" "Db3"]
             :frequency 138.59
             :wavelength 248.93
             :midi-note 49}
            {:labels ["D3"]
             :frequency 146.83
             :wavelength 234.96
             :midi-note 50}
            {:labels ["D#3" "Eb3"]
             :frequency 155.56
             :wavelength 221.77
             :midi-note 51}
            {:labels ["E3"]
             :frequency 164.81
             :wavelength 209.33
             :midi-note 52}
            {:labels ["F3"]
             :frequency 174.61
             :wavelength 197.58
             :midi-note 53}
            {:labels ["F#3" "Gb3"]
             :frequency 185.00
             :wavelength 186.49
             :midi-note 54}
            {:labels ["G3"]
             :frequency 196.00
             :wavelength 176.02
             :midi-note 55}
            {:labels ["G#3" "Ab3"]
             :frequency 207.65
             :wavelength 166.14
             :midi-note 56}
            {:labels ["A3"]
             :frequency 220.00
             :wavelength 156.82
             :midi-note 57}
            {:labels ["A#3" "Bb3"]
             :frequency 233.08
             :wavelength 148.02
             :midi-note 58}
            {:labels ["B3"]
             :frequency 246.94
             :wavelength 139.71
             :midi-note 59}
            {:labels ["C4"]
             :frequency 261.63
             :wavelength 131.87
             :midi-note 60}
            {:labels ["C#4" "Db4"]
             :frequency 277.18
             :wavelength 124.47
             :midi-note 61}
            {:labels ["D4"]
             :frequency 293.66
             :wavelength 117.48
             :midi-note 62}
            {:labels ["D#4" "Eb4"]
             :frequency 311.13
             :wavelength 110.89
             :midi-note 63}
            {:labels ["E4"]
             :frequency 329.63
             :wavelength 104.66
             :midi-note 64}
            {:labels ["F4"]
             :frequency 349.23
             :wavelength 98.79
             :midi-note 65}
            {:labels ["F#4" "Gb4"]
             :frequency 369.99
             :wavelength 98.79
             :midi-note 66}
            {:labels ["G4"]
             :frequency 392.00
             :wavelength 88.01
             :midi-note 67}
            {:labels ["G#4" "Ab4"]
             :frequency 415.30
             :wavelength 83.07
             :midi-note 68}
            {:labels ["A4"]
             :frequency 440.00
             :wavelength 78.41
             :midi-note 69}
            {:labels ["A#4" "Bb4"]
             :frequency 466.16
             :wavelength 78.41
             :midi-note 70}
            {:labels ["B4"]
             :frequency 493.88
             :wavelength 69.85
             :midi-note 71}
            {:labels ["C5"]
             :frequency 523.25
             :wavelength 65.93
             :midi-note 72}
            {:labels ["C#5" "Db5"]
             :frequency 554.37
             :wavelength 62.23
             :midi-note 73}
            {:labels ["D5"]
             :frequency 587.33
             :wavelength 58.74
             :midi-note 74}
            {:labels ["D#5" "Eb5"]
             :frequency 622.25
             :wavelength 55.44
             :midi-note 75}
            {:labels ["E5"]
             :frequency 659.25
             :wavelength 52.33
             :midi-note 76}
            {:labels ["F5"]
             :frequency 698.46
             :wavelength 49.39
             :midi-note 77}
            {:labels ["F#5" "Gb5"]
             :frequency 739.99
             :wavelength 46.62
             :midi-note 78}
            {:labels ["G5"]
             :frequency 783.99
             :wavelength 44.01
             :midi-note 79}
            {:labels ["G#5" "Ab5"]
             :frequency 830.61
             :wavelength 41.54
             :midi-note 80}
            {:labels ["A5"]
             :frequency 880.00
             :wavelength 39.20
             :midi-note 81}
            {:labels ["A#5" "Bb5"]
             :frequency 932.33
             :wavelength 37.00
             :midi-note 82}
            {:labels ["B5"]
             :frequency 987.77
             :wavelength 34.93
             :midi-note 83}
            {:labels ["C6"]
             :frequency 1046.50
             :wavelength 32.97
             :midi-note 84}
            {:labels ["C#6" "Db5"]
             :frequency 1108.73
             :wavelength 31.12
             :midi-note 85}
            {:labels ["D6"]
             :frequency 1174.66
             :wavelength 29.37
             :midi-note 86}
            {:labels ["D#6" "Eb6"]
             :frequency 1244.51
             :wavelength 27.72
             :midi-note 87}
            {:labels ["E6"]
             :frequency 1318.51
             :wavelength 26.17
             :midi-note 88}
            {:labels ["F6"]
             :frequency 1396.91
             :wavelength 24.70
             :midi-note 89}
            {:labels ["F#6" "Gb6"]
             :frequency 1479.98
             :wavelength 23.31
             :midi-note 90}
            {:labels ["G6"]
             :frequency 1567.98
             :wavelength 22.00
             :midi-note 91}
            {:labels ["G#6" "Ab6"]
             :frequency 1661.22
             :wavelength 20.77
             :midi-note 92}
            {:labels ["A6"]
             :frequency 1760.00
             :wavelength 19.60
             :midi-note 93}
            {:labels ["A#6" "Bb6"]
             :frequency 1864.66
             :wavelength 18.50
             :midi-note 94}
            {:labels ["B6"]
             :frequency 1975.53
             :wavelength 17.46
             :midi-note 95}
            {:labels ["C7"]
             :frequency 2093.00
             :wavelength 16.48
             :midi-note 96}
            {:labels ["C#7" "Db7"]
             :frequency 2217.46
             :wavelength 15.56
             :midi-note 97}
            {:labels ["D7"]
             :frequency 2349.32
             :wavelength 14.69
             :midi-note 98}
            {:labels ["D#7" "Eb7"]
             :frequency 2489.02
             :wavelength 13.86
             :midi-note 99}
            {:labels ["E7"]
             :frequency 2637.02
             :wavelength 13.08
             :midi-note 100}
            {:labels ["F7"]
             :frequency 2793.83
             :wavelength 12.35
             :midi-note 101}
            {:labels ["F#7" "Gb7"]
             :frequency 2959.96
             :wavelength 11.66
             :midi-note 102}
            {:labels ["G7"]
             :frequency 3135.96
             :wavelength 11.00
             :midi-note 103}
            {:labels ["G#7" "Ab7"]
             :frequency 3322.44
             :wavelength 10.38
             :midi-note 104}
            {:labels ["A7"]
             :frequency 3520.00
             :wavelength 9.80
             :midi-note 105}
            {:labels ["A#7" "Bb7"]
             :frequency 3729.31
             :wavelength 9.25
             :midi-note 106}
            {:labels ["B7"]
             :frequency 3951.07
             :wavelength 8.73
             :midi-note 107}
            {:labels ["C8"]
             :frequency 4186.01
             :wavelength 8.24
             :midi-note 108}
            {:labels ["C#8" "Db8"]
             :frequency 4434.92
             :wavelength 7.78
             :midi-note 109}
            {:labels ["D8"]
             :frequency 4698.63
             :wavelength 7.34
             :midi-note 110}
            {:labels ["D#8" "Eb8"]
             :frequency 4978.03
             :wavelength 6.93
             :midi-note 111}
            {:labels ["E8"]
             :frequency 5274.04
             :wavelength 6.54
             :midi-note 112}
            {:labels ["F8"]
             :frequency 5587.65
             :wavelength 6.17
             :midi-note 113}
            {:labels ["F#8" "Gb8"]
             :frequency 5919.91
             :wavelength 6.17
             :midi-note 114}
            {:labels ["G8"]
             :frequency 6271.93
             :wavelength 5.50
             :midi-note 115}
            {:labels ["G#8" "Ab8"]
             :frequency 6644.88
             :wavelength 5.19
             :midi-note 116}
            {:labels ["A8"]
             :frequency 7040.00
             :wavelength 4.90
             :midi-note 117}
            {:labels ["A#8" "Bb8"]
             :frequency 7458.62
             :wavelength 4.63
             :midi-note 118}
            {:labels ["B8"]
             :frequency 7902.13
             :wavelength 4.37
             :midi-note 119}])