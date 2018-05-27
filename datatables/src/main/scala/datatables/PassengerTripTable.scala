package datatables

import java.time.LocalDate

import slick.jdbc.PostgresProfile.api._

class PassengerTripTable(tag: Tag) extends  Table[model.PassengerInTrip](tag, "PassengerInTrip") {
  val tripId = column[Int]("trip_no", O.PrimaryKey)
  val passengerId = column[Int]("date", O.PrimaryKey)
  val date = column[LocalDate]("ID_psg", O.PrimaryKey)
  val place = column[String]("place")

  val tripIdForeignKey =foreignKey("trip_id_fk", tripId, TripTable.table)(
    _.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade)
  val passengerIdForeignKey =foreignKey("passenger_id_fk_id_fk", passengerId, PassengerTable.table)(
    _.id, ForeignKeyAction.Cascade, ForeignKeyAction.Cascade)

  def * = (tripId, passengerId, date, place) <> ((model.PassengerInTrip.apply _).tupled, model.PassengerInTrip.unapply)
}
