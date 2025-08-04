from qiskit import QuantumCircuit
import QuantumShortcuts

qc = QuantumCircuit(2, 2)

# Step 1: Set |y⟩ = |1⟩
qc.x(1)

# Step 2: Apply Hadamard to both
qc.h([0, 1])

# Step 3: Oracle for f(0)=1, f(1)=0
qc.x(0)
qc.cx(0, 1)
qc.x(0)

# Step 4: Hadamard on input again
qc.h(0)

# Step 5: Measure both (optional)
qc.measure([0,1], [0,1])
QuantumShortcuts.displayInfo(qc)

#Explanation:
# You start with a function. Constant: f(0) = 1, f(1) = 1, or f(0) = 0, f(1) = 0.
# Or, it can be balanced. f(0) = 1, f(1) = 0. f(0) = 0,f(1) = 1.
# You set the first qubit to 1 so that you can create the negative ket.
# Next, hadamard both. state is 00-01+10-11.
# Now, since its balanced, we flip the second only if f(x) = 1.
# In this example, we need to flip 01 to 00. To achieve this, we perform a temporary
# first qubit flip so we can apply a CNOT gate, then flip our first back.
# Now, our states are 10-11+00-01, and after the CNOT, 11-10+00-01.
# Recall we flip the first qubit back after this.
# States after second Pauli-X ==> 01-00+10-11. Rearranged ==> -00+01+10-11.
# When we apply hadamard on the first qubit only, we are left with: -10+11.
# Because the first qubit is alway 1, we conclude that the f(x) is indeed balanced.
# Why does this work? If f(1) = 0, f(0) = 0, we apply no flips. Thus, we return only 01 and 00
# for a second hadamard on the first qubit. (+ kets return to 0).
# The same principle applies for f(0) = 1 and f(1) = 1. we flip twice and avoid matrix interference.
# You will also notice that regardless of the output order for a balanced f(x),
# we will return the same 10,11.
# Additionally, note that when we change signs of 00 and 01, we cancel out the + kets and turn them -,
# forcing an outcome where the input qubit is always 1.
# Quantum Entanglement and Superposition, as well as phase, are all crucial in the functioning of this algorithm.
