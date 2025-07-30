from qiskit import QuantumCircuit
import QuantumShortcuts

#Step 0: Initialize
qc = QuantumShortcuts.create(2,2)

#Step 1: Apply Hadamard Gate to all Qubits
qc.h([0,1])

#Step 2: Oracle Operator (Sign Change)
qc.cz(0,1)
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
# AHHHH FINALLY I GET ITTTT.

