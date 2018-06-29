export const getGoals = state => state.goals

export const getGoal = state => id => {
  return state.goals.find(goal => goal.id === id)
}
