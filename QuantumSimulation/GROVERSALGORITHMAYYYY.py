from qiskit import QuantumCircuit
import QuantumShortcuts
# Updated understanding



#Step 0: Initialize
qc = QuantumShortcuts.create(2,2)

#Step 1: Apply Hadamard Gate to all Qubits
qc.h([0,1])

#Step 2: Oracle Operator (Sign Change)
qc.x(1)
qc.cz(0,1)
qc.x(1)
#Step 3: Diffusion
qc.h([0,1])
qc.x([0,1])
qc.cz(0,1)
qc.x([0,1])
qc.h([0,1])
qc.measure([0,1],[0,1])

QuantumShortcuts.displayInfo(qc)

#Flow: 00 => 00,01,10,11.
# 11 => -11
# Stays same after 1st h.
# Now 11, 10, 01, -00.
# Then, -11,10,01,-00.
# After, -00,01,10,-11.
# Final Hadamard on both utilizes the phase and cancellation properties to give you 100% 11!
# Result ==> 11.
# Why? Because, you need to subtract 1 from each one, bringing them to 0 except for the last. It's already -.
# So, the first column of the matrix is all positive. If we make the 1st number in the vector negative, we achieve this subtraction!
# How do we generalize this formula? We just apply X's to mark different states and it works!
# Say the answer is 01. If we prove it with the math, we get the right answer!
# But why do we need the hadamard at the beginning of diffusion?
# It sets us up for the right cancellation - in the case of 11, it doesnt do anything.
# In other cases, it switches around the marked states so that cancellation happens correctly.
# When the answer is 01, it changes that phase to 10 so when we use 00 for cancellation, 01 is amplified.
# In the same case, we utilize the 3rd number in the hadamard matrix to amplify 01. This means making 10 negative.
# So, we combine the -00 and the other flipped (or same for -11) to amplify the right answer.
# Generalized - in the nth row, if you want the nth result, you need to change the phase of the
# rth number in that row that is positive other than the first number (00 already fulfills this).
# AHHHHH LETS GOOO WE UNDERSTAND IT NOW


