package javacore_book.aboutExcept;

//Demonstrate throw.
class ThrowDemo {
	static void demoproc() {
		try {
			throw new NullPointerException("demo");
		} catch (NullPointerException e) {
			System.out.println("Caught inside demoproc.");
			throw e; // rethrow the exception
		}
	}

	public static void main(String args[]) {
		try {
			demoproc();
		} catch (NullPointerException e) {
			System.out.println("Recaught: " + e);
		}
	}
}

// This program contains an error and will not compile.
class ThrowsDemo {
	static void throwOne() throws IllegalAccessException {// 抛出异常，以便调用者做处理
		System.out.println("Inside throwOne.");
		throw new IllegalAccessException("demo");
	}

	public static void main(String args[]) {// 调用者可以使用throws或者try/catch
		try {
			throwOne();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

// Demonstrate finally.
class FinallyDemo {
	// Through an exception out of the method.
	static void procA() {
		try {
			System.out.println("inside procA");
			throw new RuntimeException("demo");
		} finally {
			System.out.println("procA's finally");
		}
	}

	// Return from within a try block.
	static void procB() {
		try {
			System.out.println("inside procB");
			return;//如果finally块与一个try联合使用，finally块将在try 结束之前执行。
		} finally {
			System.out.println("procB's finally");
		}
	}

	// Execute a try block normally.
	static void procC() {
		try {
			System.out.println("inside procC");
		} finally {
			System.out.println("procC's finally");
		}
	}

	public static void main(String args[]) {
		try {
			procA();
		} catch (Exception e) {
			System.out.println("Exception caught");
		}
		procB();
		procC();
	}
}
