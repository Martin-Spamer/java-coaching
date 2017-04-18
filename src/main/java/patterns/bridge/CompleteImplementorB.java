package patterns.bridge;

class CompleteImplementorB extends Implementor {

	@Override
	public void operation() {
		this.log.info("{}", this.getClass().getSimpleName());
	}

}
